
/* A program that creates a random line by specifying a point and moving it
according to its accelleration towards randomly generated point masses.
*/

import textio.TextIO;

public class gravityLine {

	public static void main(String[] args) {

		double wid = 500;
		double hei = 500;
		double border = 50;
		double opacity = 0.5;
		double stroke = 2.0;
		String colyr = "dodgerblue";

		double radius = 3;

		double duration = 5000;
		int gravs = 2;
		double x = 0;
		double y = 0;
		double xv = 3;
		double yv = 0;
		double ya = 0;
		double xa = 0;

		double gx = 0;
		double gy = 0;

		double dis = 0;
		double xd = 0;
		double yd = 0;

		double elost = 0.999999;

		TextIO.writeStandardOutput();
		TextIO.putln("**** GRAVITY BASED LINE GENERATOR ****");
		TextIO.putln("Enter the duration of each gravity point:");
		duration = TextIO.getlnDouble();
		TextIO.putln("Enter the number of gravity points:");
		gravs = TextIO.getlnInt();
		TextIO.putln("Enter the % energy reatined in wall collisions:");
		elost = TextIO.getlnDouble();
		TextIO.writeFile("gravityLine.svg");
		TextIO.putln("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		TextIO.putln("<!-- Generator: Adobe Illustrator 14.0.0, SVG Export Plug-In . SVG Version: 6.00 Build 43363)  -->");
		TextIO.putln(
				"<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.0//EN\" \"http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd\">");
		TextIO.putln(
				"<svg version=\"1.0\" id=\"random_line\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"");
		TextIO.putln("	 width=\"" + wid + "px\" height=\"" + hei + "px\" viewBox=\"0 0 " + wid + " " + hei + "\" ");
		TextIO.putln("enable-background=\"new 0 0 " + wid + " " + hei + "\" xml:space=\"preserve\">");

		TextIO.putln("<polyline opacity=\"" + opacity + "\" fill=\"none\" stroke=\"" + colyr + "\" ");
		TextIO.putln("stroke-width=\"" + stroke + "\" ");
		TextIO.putln("points=\"");

		x = (Math.random() * (wid - 2 * border)) + border;
		y = (Math.random() * (hei - 2 * border)) + border;

		for (int gs = 1; gs <= gravs; gs++) {

			gx = (Math.random() * (wid - 2 * border)) + border;
			gy = (Math.random() * (hei - 2 * border)) + border;

			for (int t = 1; t <= duration; t++) {
				dis = Math.sqrt((x - gx) * (x - gx) + (y - gy) * (y - gy));
				xd = x - gx;
				yd = y - gy;

				xa = (-1) * dis * xd / 250000;
				ya = (-1) * dis * yd / 250000;

				yv = yv + ya;
				xv = xv + xa;

				x = x + xv;
				y = y + yv;
				if (x < border) {
					x = border;
					xv = xv * (-elost);
				}
				if (y < border) {
					y = border;
					yv = yv * (-elost);
				}
				if (x > (500 - border)) {
					x = 500 - border;
					xv = xv * (-elost);
				}
				if (y > (500 - border)) {
					y = 500 - border;
					yv = yv * (-elost);
				}

				TextIO.putf("%1.3f,%1.3f ", x, y);
				if (t % 5 == 0)
					TextIO.putln("	");
			}

		}

		TextIO.put(" \"/>");

		TextIO.putln("</svg>");

		TextIO.writeStandardOutput();
		TextIO.putln("Gravity polyline of " + (duration * gravs) + " points was written to gravityLine.svg");
	}
}
