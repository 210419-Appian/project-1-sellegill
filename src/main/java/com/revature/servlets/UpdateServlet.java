package com.revature.servlets;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.UserDTO;

public class UpdateServlet extends HttpServlet {
	/*	
	private ObjectMapper om = new ObjectMapper();
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ses = request.getSession(false);

		if (ses != null) {
			StringBuilder sb = new StringBuilder();

			BufferedReader reader = request.getReader();

			String line = reader.readLine();

			while (line != null) {
				sb.append(line);
				// advance to the next line
				line = reader.readLine();
			}

			String body = new String(sb);

			UserDTO user = om.readValue(body, UserDTO.class);

			ses.setAttribute("username", user.username);
			System.out.println(user.password);
			response.setStatus(202);
		} else {
			response.sendRedirect("");
		}
	}
}	
*/

}