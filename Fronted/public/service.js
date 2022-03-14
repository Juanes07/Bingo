const urlApi = 'http://localhost:8098/api/game'
const urlApiNode = 'http://localhost:3000';

/**
 * guarda un nuevo juego en base de datos
 * @param  game objeto del tipo Game
 */
function saveGame (game) {
  return fetch(`${urlApi}/save`, {
    method: 'POST',
    body: JSON.stringify(game),
    headers: {
      'Content-Type': 'application/json'
    }
  })
    .then(response => response.json())
    .catch((e) => {
      console.log(e)
    })
}
/**
 * funcion para traer un listado de juegos
 * @param  game objeto del tipo Game
 */
function getAllGame(game) {
  fetch(`${urlApi}/all`)
    .then((response) => {
      return response.json(game)
    })
    .then((resp) => {
      console.log(resp)
    })
    .catch((e) => {
      console.log(e)
    })
}
/**
 * funcion para obtener el juego basado en su state
 * @param {String} status  referencia al state de la tabla game en la base de datos
 */
function getGameByStatus (status) {
  return fetch(`${urlApi}/status?status=${status}`)
    .then((response) => {
      return response.json()
    })
    .catch((e) => {
      console.log(e)
    })
}
/**
 *  funcion para obtener un usuario por medio del Identificador del juego
 * @param {Integer} gameId referencia al id del juego en la base de datos
 */
function getUserByGameId (gameId) {
  return fetch(`${urlApi}/${gameId}/user`)
    .then((response) => {
      return response.json()
    })
    .catch((e) => {
      console.log(e)
    })
}
/**
 * funcion para comenzar un juego, cambiando su state a ACTIVE
 * @param {Integer} gameId referencia al id del juego en la base de datos
 */
function startGame (gameId) {
  fetch(`${urlApi}/start_game/${gameId}`)
    .then((response) => {
      return response.json()
    })
    .then((resp) => {
      console.log(resp)
    })
    .catch((e) => {
      console.log(e)
    })
}
/**
 *  funcion para agregar un usuario a la una partida
 * @param {String} gameId referencia al id del juego en la base de datos
 * @param {String} userId referencia al id del usuario en mongodb
 */
function addUserToGame (user) {
  return fetch(`${urlApi}/user/save`, {
    method: 'POST',
    body: JSON.stringify(user),
    headers: {
      'Content-Type': 'application/json'
    }
  })
    .then((response) => {
      return response.json()
    })
    .catch((e) => {
      console.log(e)
    })
}

function saveBallotGame (ballot) {
  fetch(`${urlApi}/ballot_used/save`, {
    method: 'POST',
    body: JSON.stringify(ballot)
  })
    .then((response) => {
      return response.json()
    })
    .then((resp) => {
      console.log(resp)
    })
    .catch((e) => {
      console.log(e)
    })
}

function getBallotByGameId (gameId) {
  fetch(`${urlApi}/${gameId}/ballot`)
    .then((response) => {
      return response.json()
    })
    .then((resp) => {
      console.log(resp)
    })
    .catch((e) => {
      console.log(e)
    })
}

function saveCartoon (cartoon) {
  fetch(`${urlApi}/${cartoon}/save`, {
    method: 'POST',
    body: JSON.stringify(cartoon)
  })
    .then((response) => {
      return response.json()
    })
    .then((resp) => {
      console.log(resp)
    })
    .catch((e) => {
      console.log(e)
    })
}

/**
 *  funcion para traer el carton pertenenciente al usuario por medio del identificador del juego
 * @param {String} gameId referencia al id del juego en la base de datos
 * @param {String} userId referencia al id del usuario en mongodb
 */

function getCartoonByGameIdAndUserId(gameId, userId) {
  fetch(`${urlApi}/${gameId}/cartoon/user/${userId}`)
    .then((response) => {
      return response.json()
    }).then((resp) => {
      console.log(resp)
    })
    .catch((e) => {
      console.log(e)
    })
}

function getUserById(userId) {
  return fetch(`${urlApiNode}/user/${userId}`).then(response => response.json()).catch(e => console.log(e))
}
