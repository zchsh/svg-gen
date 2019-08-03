const defaultValues = {
  stroke: 1,
  color: "dodgerblue",
  numpoints: 10,
  numlines: 4,
  opacity: 1
};

function mapLineIdxToColor(idx) {
  return idx % 3 === 0 ? "cyan" : idx % 3 === 1 ? "magenta" : "yellow";
}

function meanderLine(opts) {
  var x = 0;
  var y = 0;
  var xt = 0;
  var yt = 0;
  var numpoints = opts ? opts.numpoints : defaultValues.numpoints;
  var width = 500;
  var height = 500;
  var border = 10;
  var pointsep = 10;

  var numlines = opts ? opts.numlines : defaultValues.numlines;

  var opacity = opts ? opts.opacity : defaultValues.opacity;
  var color = opts ? opts.color : defaultValues.color;
  var stroke = opts ? opts.stroke : defaultValues.stroke;

  let svgOutput = "";
  svgOutput += `<svg version="1.0" id="random_line" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"`;
  svgOutput += `width="${width}px" height="${height}px" viewBox="0 0 ${width} ${height}">`;

  for (var n = 1; n <= numlines; n++) {
    color = opts.useCmyLines ? mapLineIdxToColor(n) : color;
    svgOutput += `<polyline opacity="${opacity}" fill="none" stroke="${color}" stroke-width="${stroke}" points="`;
    xt = Math.random() * (width - 2 * border) + border;
    yt = Math.random() * (width - 2 * border) + border;

    for (var g = 1; g <= numpoints; g++) {
      x = Math.random() * pointsep - pointsep / 2 + xt;
      y = Math.random() * pointsep - pointsep / 2 + yt;
      if (x < border) x = border;
      if (x > width - border) x = width - border;
      if (y < border) y = border;
      if (y > height - border) y = height - border;
      svgOutput += `${x},${y} `;

      xt = x;
      yt = y;
    }

    svgOutput += ` "/>`;
  }
  // SVG FILE ENDING

  svgOutput += `</svg>`;

  return svgOutput;
}

export default meanderLine;
