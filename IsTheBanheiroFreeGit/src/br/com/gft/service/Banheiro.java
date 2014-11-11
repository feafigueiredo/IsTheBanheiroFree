package br.com.gft.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.gft.model.EstadoBanheiro;

public class Banheiro extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		EstadoBanheiro estado = EstadoBanheiro.getInstance();

		System.out.println("Entrei");
		System.out.println(estado);

		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.print(estado);

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		EstadoBanheiro estado = EstadoBanheiro.getInstance();

		System.out.println("Entrei");
		System.out.println(estado);

		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.print(estado);

	}
}
