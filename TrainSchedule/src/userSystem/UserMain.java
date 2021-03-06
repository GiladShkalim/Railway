package userSystem;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import TrainSchedule.IsearchRides;
import TrainSchedule.RidesManagement;

public class UserMain implements IsearchRides {

	public static void main(String[] args) throws Exception {
		String out = new SimpleDateFormat("yyyy-MM-dd '.txt'").format(new Date());
		File f = new File("/home/afeka/Desktop/railWay " + out);
		Scanner s = new Scanner(f);
		RidesManagement.FiletoUserInsertion(s);

		int hour = Integer.parseInt(args[3]);
		int minute = Integer.parseInt(args[4]);
		RidesManagement.sortAll();
		RidesManagement.stringRides();
		String route = IsearchRides.search(args[1], args[2], hour, minute);

		boolean isHtml = args[0].equalsIgnoreCase("html") & args.length > 0;
		if (!isHtml) {
			System.out.println(route);
		} else {
			String[] parts = route.split("Main");
			System.out.println("<html>");
			System.out.println("<head>");
			System.out.println("<title>");
			System.out.println("Rail Israel");
			System.out.println("</title>");
			System.out.println("</head>");
			System.out.println("<body style=\"background-color:#E0E0E0;\">");
			// Logo
			System.out.println(
					"<a href=\"https://github.com/GiladShkalim/Railway\"><h1 style=\"text-align: center;\"><span style=\"text-decoration: underline;\"><span style=\"color: #0000ff;\"><strong>Rail-Way Israel</strong></span></span></h1></a>");
			// Search
			System.out.println("<h2 style=\"background-color:#ABC1FF;\"> <br/> Plan Ride");
			System.out.println(
					"<table class=\"editorDemoTable\" style=\"border-collapse: collapse; background:transparent; width: 1000px;\" align=\"center\" cellspacing=\"5\"\">"
							+ "<tbody>" + "<tr style=\"height: 30px;\"><td> </td></tr>"
							+ "<tr style=\"height: 10px; background:transparent;\">"
							+ "<td style=\"text-align: center; width: 400px; height: 14px; color:#ffffff;\"><h4>Start</h4></td>"
							+ "<td style=\"text-align: center; width: 400px; height: 14px; color:#ffffff;\"><h4>Finish</h4></td>"
							+ "<td style=\"text-align: center; width: 100px; height: 14px; color:#ffffff; text-align: right;\"><h4>Hour</h4></td>"
							+ "<td></td>" + "</tr>" + "<tr style=\"height: 30.05px;\">"
							+ "<form action=\"{{ url_for(/rail) }}\" method=\"post\">" + // Corrent PATH of Python code
																							// = working code
							"<td style=\"width: 350px; height: 30px; text-align: center;\">"
							+ "<input id=\"startStation\" name=\"startStation\" style=\"text-align: center;\" role=\"combobox\" autocomplete=\"off\" type=\"text\" aria-expanded=\"false\" aria-autocomplete=\"list\" value=\""
							+ args[1] + "\"/></td>" + "<td style=\"width: 350px; height: 30px; text-align: center;\">\n"
							+ "<input id=\"finishStation\" name=\"finishStation\" style=\"text-align: center;\" role=\"combobox\" autocomplete=\"off\" type=\"text\" aria-expanded=\"false\" aria-autocomplete=\"list\" value=\""
							+ args[2] + "\"/></td>" + "<td style=\"width: 100px;\" align=\"center\">\n"
							+ "<input style=\"width: 100px;\" id=\"Hour\" name=\"Hour\" style=\"text-align: center;\" role=\"combobox\" autocomplete=\"off\" type=\"text\" aria-expanded=\"false\" aria-autocomplete=\"list\" value=\""
							+ args[3] + "\"/></td>" + "<td style=\"width: 100px;\" align=\"left\">\n"
							+ "<input style=\"width: 100px;\" id=\"minutes\" name=\"minutes\" style=\"text-align: center;\" role=\"combobox\" autocomplete=\"off\" type=\"text\" aria-expanded=\"false\" aria-autocomplete=\"list\" value=\""
							+ args[4] + "\"/></td>" + "</td>" + "</from>"
							+ "<td style=\"width: 200px; height: 30px; text-align: center;\">"
							+ "<button type=\"submit\" form=\"myRide\" value=\"Search\">Search</button>" + "</td>");
			// Route
			System.out.println("<tr style=\"height: 30px;\"><td></td></tr>");
			System.out.println("</tbody></table></h2>");
			System.out.println("<h2 style=\"background-color:#A6FCFF;\"> <br/> Youre route");
			System.out.println("<table class=\"editorDemoTable\" style=\"border-collapse: collapse;"
					+ "background:transparent; width: 1000px;\" align=\"center\" cellspacing=\"5\"\">" + "<tbody>");
			System.out.println("<tr style=\"height: 10px; background:transparent;\">");
			System.out.println("<td style=\"text-align: left; width: 400px; height: 14px; color:#000000;\">");
			System.out.println("<h5>");
			String[] routs = route.split("Main ");
			for (int i = 0; i < routs.length; i++) {

				System.out.println("<br>");

				String timeLine = routs[i];
				String[] sParts = timeLine.split("Full ");
				for (int j = 0; j < sParts.length; j++) {

					String stationStr = sParts[j];
					String[] midStaiStr = stationStr.split("Station ");
					for (int k = 0; k < midStaiStr.length; k++) {
						System.out.println(midStaiStr[k]);
						System.out.println("<br>");
					}

				}
			}
			System.out.println("</h5>");
			System.out.println("</td></tr>");
			System.out.println("<tr style=\"height: 30px;\"><td></td></tr>");
			System.out.println("</tbody></table></h2>");
			// Names
			System.out.println("<h3 style=\"background-color:#4D494C;\">");
			System.out.println(
					"<table class=\"editorDemoTable\" style=\"border-collapse: collapse; background:transparent; width: 1500px;\" align=\"center\" cellspacing=\"5\"\">"
							+ "<tbody>" + "<tr style=\"height: 50px; background:transparent;\">"
							+ "<td style=\"text-align: center; width: 400px; height: 50px; color:#ffffff;\">Gilad Shkalim</td>"
							+ "<td></td>\n" + "</tr>");
			System.out.println("</tbody></table></h3>");
			System.out.println("</html>");
		}
	}
}
