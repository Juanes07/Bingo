// do {
//     const numero = Math.round(Math.random()*(numinitial-numfinal) + numfinal);
// } while ( )
let segundoinicio = 60

function update () {
  document.getElementById('seconds').innerHTML = segundoinicio
  if (segundoinicio === 0) {
    alert ('finalizado')
  } else {
    segundoinicio -= 1
    setTimeout(update, 1E3)
  }
}
