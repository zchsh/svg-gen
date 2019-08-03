
/*
An application to output a basic polyline to an svg file. User specifies # of points
on the polyline, as well as the width and height (in pixels) of the document.

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

public class randomPolyline {

	public static void main(String[] args) {

		double x = 0;
		double y = 0;
		int numpoints = 0;
		double wid = 0;
		double hei = 0;
		double border = 0;
		double opacity = 0;

		double stroke = 0;
		double stroke2 = 0;
		double stroke3 = 0;

		String collor = "black";
		String collor2 = "black";
		String collor3 = "black";

		TextIO.writeStandardOutput();
		TextIO.putln("**** RANDOM POLYLINE CREATOR ****");
		TextIO.putln("**** AVAILABLE COLORS ****");
		TextIO.putln("cyan, magenta, yellow");
		TextIO.putln("dodgerblue, deeppink, gold");
		TextIO.putln("Please enter the width of the document in pixels.");
		wid = TextIO.getlnDouble();
		TextIO.putln("Please enter the height of the document in pixels.");
		hei = TextIO.getlnDouble();
		TextIO.putln("Please enter a border size in px");
		border = TextIO.getlnDouble();
		TextIO.putln("Please enter the line opacity.");
		opacity = TextIO.getlnDouble();

		// for each line

		TextIO.putln("**** FOR THE FIRST LINE ****");
		TextIO.putln("Please enter the desired path color.");
		TextIO.putln("Available colors listed above.");
		collor = TextIO.getln();
		TextIO.putln("Please enter the desired stroke width.");
		stroke = TextIO.getlnDouble();
		TextIO.putln("Please enter the desired number of points.");
		numpoints = TextIO.getlnInt();

		TextIO.putln("**** FOR THE SECOND LINE ****");
		TextIO.putln("Please enter the desired path color.");
		TextIO.putln("Available colors listed above.");
		collor2 = TextIO.getln();
		TextIO.putln("Please enter the desired stroke width.");
		stroke2 = TextIO.getlnDouble();
		TextIO.putln("Please enter the desired number of points.");
		numpoints = TextIO.getlnInt();

		TextIO.putln("**** FOR THE THIRD LINE ****");
		TextIO.putln("Please enter the desired path color.");
		TextIO.putln("Available colors listed above.");
		collor3 = TextIO.getln();
		TextIO.putln("Please enter the desired stroke width.");
		stroke3 = TextIO.getlnDouble();
		TextIO.putln("Please enter the desired number of points.");
		numpoints = TextIO.getlnInt();

		// end for

		TextIO.writeFile("randomPolyline.svg");
		TextIO.putln("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		TextIO.putln("<!-- Generator: Adobe Illustrator 14.0.0, SVG Export Plug-In . SVG Version: 6.00 Build 43363)  -->");
		TextIO.putln(
				"<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.0//EN\" \"http://www.w3.org/TR/2001/REC-SVG-20010904/DTD/svg10.dtd\">");
		TextIO.putln(
				"<svg version=\"1.0\" id=\"random_line\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"");
		TextIO.putln("	 width=\"" + wid + "px\" height=\"" + hei + "px\" viewBox=\"0 0 " + wid + " " + hei + "\" ");
		TextIO.putln("enable-background=\"new 0 0 " + wid + " " + hei + "\" xml:space=\"preserve\">");

		// FIRST LINE

		TextIO.putln("<polyline opacity=\"" + opacity + "\" fill=\"none\" stroke=\"" + collor + "\" ");
		TextIO.putln("stroke-width=\"" + stroke + "\" ");
		TextIO.putln("points=\"");

		for (int g = 1; g <= numpoints; g++) {
			x = (Math.random() * (wid - 2 * border)) + border;
			y = (Math.random() * (hei - 2 * border)) + border;
			TextIO.putf("%1.3f,%1.3f ", x, y);
			if (g % 5 == 0)
				TextIO.putln("	");
		}

		TextIO.put(" \"/>");

		// SECOND LINE

		TextIO.putln("<polyline opacity=\"" + opacity + "\" fill=\"none\" stroke=\"" + collor2 + "\" ");
		TextIO.putln("stroke-width=\"" + stroke2 + "\" ");
		TextIO.putln("points=\"");

		for (int g = 1; g <= numpoints; g++) {
			x = (Math.random() * (wid - 2 * border)) + border;
			y = (Math.random() * (hei - 2 * border)) + border;
			TextIO.putf("%1.3f,%1.3f ", x, y);
			if (g % 5 == 0)
				TextIO.putln("	");
		}

		TextIO.put(" \"/>");

		// THIRD LINE

		TextIO.putln("<polyline opacity=\"" + opacity + "\" fill=\"none\" stroke=\"" + collor3 + "\" ");
		TextIO.putln("stroke-width=\"" + stroke3 + "\" ");
		TextIO.putln("points=\"");

		for (int g = 1; g <= numpoints; g++) {
			x = (Math.random() * (wid - 2 * border)) + border;
			y = (Math.random() * (hei - 2 * border)) + border;
			TextIO.putf("%1.3f,%1.3f ", x, y);
			if (g % 5 == 0)
				TextIO.putln("	");
		}

		TextIO.put(" \"/>");

		TextIO.putln("</svg>");

		TextIO.writeStandardOutput();
		TextIO.putln("Random polyline of " + numpoints + " points was written to randomPolyline.svg");

	}
}
