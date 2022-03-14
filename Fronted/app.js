/**
 * Librerias importadas
 */

const express = require('express')
const path = require('path')
const bodyParser = require('body-parser')
const app = express()
const bcrypt = require('bcrypt')
const mongoose = require('mongoose')
const User = require('./userschema')
const fetch = require('node-fetch')

/**
 * conexion a base de datos mongo
 */
const mongodb = 'mongodb://localhost/bingo'
mongoose.connect(mongodb, { useNewUrlParser: true, useUnifiedTopology: true })
  .then(() => console.log('MongoDB connected'))
  .catch(err => console.log(err))

app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extends: false }))

app.use(express.static(path.join(__dirname, 'public')))

app.post('/register', (req, res) => {
  const { username, password } = req.body
  const user = new User({ username, password })
  user.save(err => {
    if (err) {
      res.status(500).send('Usuario ya existe usuario')
    } else {
      res.redirect('index.html')
    }
  })
})

app.post('/authenticate', (req, res) => {
  const { username, password } = req.body
  User.findOne({ username }, (err, user) => {
    if (err) {
      res.status(500).send('error al autenticar usuario')
    } else if (!user) {
      res.status(500).send('EL usuario no existe')
    } else {
      user.isCorrectPassword(password, (err, result) => {
        if (err) {
          res.status(500).send('error al autenticar usuario')
        } else if (result) {
          res.status(200).json({ id: user._id })
        } else {
          res.status(500).send('usuario y/o contraseña incorrecta')
        }
      })
    }
  })
})

app.get('/user/:id', (req, res) => {
  const id = req.params.id
  User.findById(id, (err, user) => {
    if (err) return res.status(500).send({ message: `Error en la peticion: ${err}` })
    if (!user) return res.status(404).send({ message: 'No existe usuario' })
    res.send(200, user)
  })
})

app.listen(3000, () => console.log('server cargado'))

module.exports = app
