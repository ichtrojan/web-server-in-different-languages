let http = require('http')

const PORT = 3000

let server = http.createServer((req, res) => {
  res.statusCode = 200
  res.setHeader('Content-Type', 'text/plain')
  res.end('Hello, World!\n')
})

server.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`)
})
