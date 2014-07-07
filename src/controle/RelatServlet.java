package controle;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.RelatorioUtil;

@WebServlet("/RelatServlet")
public class RelatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Map<String, Object> parametros = new HashMap<String, Object>();

		String nomeRelat = request.getParameter("nomeRelat");

		if (nomeRelat.equalsIgnoreCase("relatorioEntrada")) {
			
			String aux = request.getParameter("dataInicial");
			String aux1 = request.getParameter("dataFinal");
			
			
			parametros.put("2010-12-21",aux);
			parametros.put("2014-12-21", aux1);
	
		}

		String arquivoJasper = getServletContext().getRealPath(
				"/WEB-INF/relatorios/" + nomeRelat + ".jasper");

		byte[] bytes = RelatorioUtil.criarRelatorio(arquivoJasper, parametros);

		if (bytes != null && bytes.length > 0) {
			response.setContentType("application/pdf");
			response.setContentLength(bytes.length);
			ServletOutputStream ouputStream = response.getOutputStream();
			ouputStream.write(bytes, 0, bytes.length);
			ouputStream.flush();
			ouputStream.close();
		}
	}
}
