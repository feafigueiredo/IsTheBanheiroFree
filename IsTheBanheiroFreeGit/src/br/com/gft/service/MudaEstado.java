package br.com.gft.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.gft.model.EstadoBanheiro;
import br.com.gft.model.EstadoRecebido;

public class MudaEstado extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EstadoBanheiro estado = EstadoBanheiro.getInstance();
		
		resp.setContentType("application/json");
		
		Gson gson = new GsonBuilder().create();
		EstadoRecebido myReq = gson.fromJson(req.getReader(), EstadoRecebido.class);
		System.out.println("Recebi: " + myReq);
		estado.setFeminino(myReq.isFeminino());
		estado.setMasculino(myReq.isMasculino());
		System.out.println("Mudei estado: " + estado);
		resp.setContentType("application/json");
		PrintWriter out = resp.getWriter();
		out.print(estado);
	}
}
