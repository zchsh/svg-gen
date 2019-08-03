const defaultValues = {
  stroke: 1,
  color: "dodgerblue",
  gravityPoints: 2
};

function generateSvg(opts) {
  var width = 500;
  var height = 500;
  var border = 50;
  var opacity = 0.5;
  var color = opts ? opts.color : defaultValues.color;
  var stroke = opts ? opts.stroke : defaultValues.stroke;
  var duration = 500;

  var gravityPoints = opts ? opts.gravityPoints : defaultValues.gravityPoints;

  var x = 0;
  var y = 0;
  var xv = 3;
  var yv = 0;
  var ya = 0;
  var xa = 0;

  var gx = 0;
  var gy = 0;

  var dis = 0;
  var xd = 0;
  var yd = 0;

  var elost = 0.999999;

  let svgOutput = "";
  svgOutput += `<svg version="1.0" id="random_line" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px"`;
  svgOutput += `width="${width}px" height="${height}px" viewBox="0 0 ${width} ${height}">`;
  svgOutput += `<polyline opacity="${opacity}" fill="none" stroke="${color}" stroke-width="${stroke}" points="`;

  x = Math.random() * (width - 2 * border) + border;
  y = Math.random() * (height - 2 * border) + border;

  for (var gs = 1; gs <= gravityPoints; gs++) {
    gx = Math.random() * (width - 2 * border) + border;
    gy = Math.random() * (height - 2 * border) + border;

    for (var t = 1; t <= duration; t++) {
      dis = Math.sqrt((x - gx) * (x - gx) + (y - gy) * (y - gy));
      xd = x - gx;
      yd = y - gy;

      xa = (-1 * dis * xd) / 250000;
      ya = (-1 * dis * yd) / 250000;

      yv = yv + ya;
      xv = xv + xa;

      x = x + xv;
      y = y + yv;
      if (x < border) {
        x = border;
        xv = xv * -elost;
      }
      if (y < border) {
        y = border;
        yv = yv * -elost;
      }
      if (x > 500 - border) {
        x = 500 - border;
        xv = xv * -elost;
      }
      if (y > 500 - border) {
        y = 500 - border;
        yv = yv * -elost;
      }

      svgOutput += `${x},${y} `;
    }
  }

  svgOutput += ` "/>`;
  svgOutput += `</svg>`;

  return svgOutput;
}

export default generateSvg;
