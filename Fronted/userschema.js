const mongoose = require('mongoose')
const bcrypt = require('bcrypt')

const saltRounds = 10
// Schema usuario
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
// encryptar password
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
