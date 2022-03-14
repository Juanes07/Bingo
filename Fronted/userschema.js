/**
 * librerias importadas
 */

const mongoose = require('mongoose')
const bcrypt = require('bcrypt')
/**
 * consiste en las veces que se encripta la contraseña
 */
const saltRounds = 10
/**
 * creacion del Schema usuario
 */
const userSchema = new mongoose.Schema({
  username: {
    type: String,
    required: true,
    unique: true
  },
  password: {
    type: String,
    require: true
  }
})
/**
 * encryptar contraseña
 */
userSchema.pre('save', function (next) {
  if (this.isNew || this.isModified('password')) {
    const document = this
    bcrypt.hash(document.password, saltRounds, (err, hashedPassword) => {
      if (err) {
        next(err)
      } else {
        document.password = hashedPassword
        next()
      }
    })
  } else {
    next()
  }
})

userSchema.methods.isCorrectPassword = function (password, callback) {
  bcrypt.compare(password, this.password, function (err, same) {
    if (err) {
      callback(err)
    } else {
      callback(err, same)
    }
  })
}

userSchema.methods.findByusername = function (username) {
  return userSchema.findOne({ username })
}

module.exports = mongoose.model('User', userSchema)
