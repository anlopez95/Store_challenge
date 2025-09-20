// scripts/plantuml-encode.js
// Uso: node scripts/plantuml-encode.js docs/puml/ejemplo.puml
// Genera una URL lista para insertar en Markdown

const fs = require('fs');
const pako = require('pako');

// Funciones de codificación especial de PlantUML
function encode6bit(b) {
  const chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz-_";
  return chars.charAt(b & 0x3F);
}

function append3bytes(b1, b2, b3) {
  const c1 = b1 >> 2;
  const c2 = ((b1 & 0x3) << 4) | (b2 >> 4);
  const c3 = ((b2 & 0xF) << 2) | (b3 >> 6);
  const c4 = b3 & 0x3F;
  return encode6bit(c1) + encode6bit(c2) + encode6bit(c3) + encode6bit(c4);
}

function encode64(data) {
  let res = "";
  for (let i = 0; i < data.length; i += 3) {
    if (i + 2 === data.length) {
      res += append3bytes(data[i], data[i + 1], 0);
    } else if (i + 1 === data.length) {
      res += append3bytes(data[i], 0, 0);
    } else {
      res += append3bytes(data[i], data[i + 1], data[i + 2]);
    }
  }
  return res;
}

function plantumlEncode(text) {
  const deflated = pako.deflateRaw(text, { level: 9 });
  return encode64(deflated);
}

// Programa principal
if (process.argv.length < 3) {
  console.error("Uso: node scripts/plantuml-encode.js archivo.puml");
  process.exit(1);
}

const filePath = process.argv[2];
const source = fs.readFileSync(filePath, 'utf-8');
const encoded = plantumlEncode(source);

const url = "https://www.plantuml.com/plantuml/svg/" + encoded;
console.log("✅ URL generada:");
console.log(url);
