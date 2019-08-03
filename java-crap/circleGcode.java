
// a program to generate g code that draws a 50 unit diameter circle in the
// centre of a 200 mm x 200 mm platen

import textio.TextIO;

public class circleGcode {

	public static void main(String[] args) {

		double x;
		double y;
		double h = 100; // x CoORD of circle centre
		double k = 100; // y CoORD of circle centre
		double radius = 50;

		Boolean penup = true;

		TextIO.writeFile("circleGcode.gcode");

		// FOR GCODE FILE
		TextIO.putln("G21");
		TextIO.putln("G90");
		TextIO.putln("G28");
		TextIO.putln("G1 F3000");
		TextIO.putln("G1 Z3"); // "pen up" command

		// FOR WRITING TO SVG DURING TESTING
		// TextIO.putln("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		// TextIO.putln("<!-- Generator: Adobe Illustrator 14.0.0, SVG Export Plug-In .
		// SVG Version: 6.00 Build 43363) -->");
		// TextIO.putln("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\"
		// \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">");
		// TextIO.putln("<svg version=\"1.1\" id=\"Layer_1\"
		// xmlns=\"http://www.w3.org/2000/svg\"
		// xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"");
		// TextIO.putln(" width=\"200px\" height=\"200px\" viewBox=\"0 0 200 200\"
		// enable-background=\"new 0 0 200 200\" xml:space=\"preserve\">");
		// TextIO.putln("<polyline fill=\"#FFFFFF\" stroke=\"#000000\" points=\"");

		for (double n = 0; n < 200; n = n + 0.1) {
			x = n;
			// x^2 + y^2 = r^2
			y = Math.sqrt((radius * radius) - (x - h) * (x - h)) + k;
			if (Double.isNaN(y))
				;
			else {
				// SVG
				// TextIO.putln(x + "," + y + " ");

				// GCODE
				TextIO.putln("G1 X" + x + " Y" + y);
				if (penup == true) {
					TextIO.putln("G1 Z0");
					penup = false;
				}

			}
		}

		for (double n = 200; n >= 0; n = n - 0.1) {
			x = n;
			y = (-1 * (Math.sqrt((radius * radius) - (x - h) * (x - h))) + k);
			if (Double.isNaN(y))
				;
			else {
				// SVG
				// TextIO.putln(x + "," + y + " ");

				// GCODE
				TextIO.putln("G1 X" + x + " Y" + y);
				if (penup == true) {
					TextIO.putln("G1 Z0");
					penup = false;
				}

			}
		}

		// FOR SVG
		// TextIO.putln("\"/>");
		// TextIO.putln("</svg>");

	}
}
