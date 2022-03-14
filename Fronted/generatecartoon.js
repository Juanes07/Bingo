
/**
 * Genera numero aleatorio
 * @param {int} min numero minimo del rango
 * @param {itn} max numero maximo del rango
 * @returns numero aleatorio
 */
function generateRandom (min, max) {
  return Math.floor(Math.random() * (max - min + 1) + min)
}

/**
 * genera los valores para cada columna del carton
 * @param {int} min numero minimo del rango
 * @param {int} max numero maximo del rango
 * @param {int} quantity cantidad de numeros en la columna
 * @returns la columna
 */
function generatecolumn (min, max, quantity) {
  const column = []
  while (column.length < quantity) {
    const numberRandom = generateRandom(min, max)
    let exist = false
    for (let i = 0; i < column.length; i++) {
      if (column[i] === numberRandom) {
        exist = true
        break
      }
    }
    if (!exist) {
      column.push(numberRandom)
    }
  }
  return column
}
/**
 * genera el carton para jugar
 */
function generateCartoon () {
  const B = generatecolumn(1, 15, 5)
  const I = generatecolumn(16, 30, 5)
  const N = generatecolumn(31, 45, 4)
  const G = generatecolumn(46, 60, 5)
  const O = generatecolumn(61, 75, 5)
  return console.log([B, I, N, G, O])
}

generateCartoon()
