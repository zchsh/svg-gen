
/*
An application to output a basic polyline to an svg file. User specifies # of points
on the polyline, as well as the width and height (in pixels) of the document
, line width, and line color.

Available colors:

cyan
magenta
yellow

dodgerblue
deeppink
gold

blanchedalmond
aquamarine
crimson
burlywood
skyblue
lightsteelblue
hotpink

*/

import textio.TextIO;

public class meanderLine {

	public static void main(String[] args) {

		// VARIABLE DECALARATION

		double x = 0;
		double y = 0;
		double xt = 0;
		double yt = 0;
		int numpoints = 0;
		double wid = 0;
		double hei = 0;
		double border = 0;
		double pointsep = 0;

		int numlines = 1;

		int numfiles = 1;

		double opacity = 0;
		double stroke = 0;
		String colyr = "black";

		// USER INPUT FOR VARIABLES

		TextIO.writeStandardOutput();
		TextIO.putln("**** MEANDERING POLYLINE CREATOR ****");

		TextIO.putln("How many files should I make?");
		numfiles = TextIO.getlnInt();

		TextIO.putln("Please enter doc. width in pixels:");
		wid = TextIO.getlnDouble();
		TextIO.putln("Please enter doc. height in pixels:");
		hei = TextIO.getlnDouble();
		TextIO.putln("Please enter a border size in pixels:");
		border = TextIO.getlnDouble();

		TextIO.putln("Please enter the desired path color.");
		colyr = TextIO.getln();
		TextIO.putln("Please enter the desired stroke width.");
		stroke = TextIO.getlnDouble();
		TextIO.putln("Please enter the stroke opacity.");
		opacity = TextIO.getlnDouble();
		TextIO.putln("Please enter the desired number of points per line.");
		numpoints = TextIO.getlnInt();
		TextIO.putln("Please enter the max distance between points (px):");
		pointsep = TextIO.getlnDouble();
		TextIO.putln("Please enter the number of seperate lines (Starting points):");
		numlines = TextIO.getlnInt();

		// FOR STATEMENT TO WRITE TO MULTIPLE SVG FILES AT ONCE

		for (int k = 1; k <= numfiles; k++) {

			// SVG FILE PRE-AMBLE

			TextIO.writeFile("meanderLine" + k + ".svg");

			TextIO.putln("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
			TextIO
					.putln("<!-- Generator: Adobe Illustrator 14.0.0, SVG Export Plug-In . SVG Version: 6.00 Build 43363)  -->");
			TextIO.putln(
					"<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.0//EN\" \"http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd\">");
			TextIO.putln(
					"<svg version=\"1.0\" id=\"random_line\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"");
			TextIO.putln("	 width=\"" + wid + "px\" height=\"" + hei + "px\" viewBox=\"0 0 " + wid + " " + hei + "\" ");
			TextIO.putln("enable-background=\"new 0 0 " + wid + " " + hei + "\" xml:space=\"preserve\">");

			// FOR A SINGLE STROKE

			for (int n = 1; n <= numlines; n++) {

				TextIO.putln("<polyline opacity=\"" + opacity + "\" fill=\"none\" stroke=\"" + colyr + "\" ");
				TextIO.putln("stroke-width=\"" + stroke + "\" ");
				TextIO.putln("points=\"");

				xt = (Math.random() * (wid - 2 * border)) + border;
				yt = (Math.random() * (wid - 2 * border)) + border;

				for (int g = 1; g <= numpoints; g++) {
					x = (Math.random() * pointsep - pointsep / 2) + xt;
					y = (Math.random() * pointsep - pointsep / 2) + yt;
					if (x < border)
						x = border;
					if (x > (wid - border))
						x = wid - border;
					if (y < border)
						y = border;
					if (y > (hei - border))
						y = hei - border;
					TextIO.putf("%1.3f,%1.3f ", x, y);
					if (g % 5 == 0)
						TextIO.putln("	");
					xt = x;
					yt = y;

				}

				TextIO.put(" \"/>");

			}
			// SVG FILE ENDING

			TextIO.putln("</svg>");

		}

		// COMFIRMATION FOR RESTLESS USER

		TextIO.writeStandardOutput();
		TextIO.putln("Random polyline of " + (numlines * numpoints) + " points was written to meanderLine.svg");
	}
}
