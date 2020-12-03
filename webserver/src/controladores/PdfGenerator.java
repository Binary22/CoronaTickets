package controladores;


import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import com.itextpdf.text.pdf.draw.LineSeparator;

import logica.DataFuncion;
import logica.DataUsuario;
import logica.Publicador;
import logica.PublicadorService;

/**
 * Servlet implementation class PdfGenerator
 */
@WebServlet("/PdfGenerator")
public class PdfGenerator extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PdfGenerator() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	HttpSession objSesion = req.getSession();
    	if (objSesion.getAttribute("estado_sesion") == "LOGIN_INCORRECTO") {
			resp.sendRedirect("home");
		}
		PublicadorService service = new PublicadorService();
	    Publicador port = service.getPublicadorPort();
		String nickname = (String)objSesion.getAttribute("usuario_logueado");
		DataUsuario user = port.getUsuario(nickname);
		String nombreU = user.getNombre();
		String apellido = user.getApellido();
		String fechaActual = LocalDate.now().toString();
		
		String nombre = req.getParameter("name");
		int iend = nombre.indexOf(";");
		String nomEspect = null;
		String nomFun = null;
		if (iend != -1) 
		{
		    nomEspect = nombre.substring(0 , iend); 
		    nomFun = nombre.substring(iend + 1,  nombre.length());
		}
		
		DataFuncion funcion = port.getFuncion(nomEspect, nomFun);
		String fechaSorteo = funcion.getFechaSorteo();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date =  LocalDate.parse(fechaSorteo, formatter);
        String fechaHabil = date.plusDays(30).toString();
	    
		//get the output stream for writing binary data in the response.
		ServletOutputStream os = resp.getOutputStream();
		//set the response content type to PDF
		resp.setContentType("application/pdf"); 
		//create a new document
		Document doc = new Document();
  	 
		try{
  	    
			//create an instance of the PdfWriter using the output stream
			PdfWriter.getInstance(doc, os);
			doc.addTitle("certificacion");
			doc.addAuthor("coronaTickets.uy");
			doc.addSubject("certificado del premio");
			doc.open();
			Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,Font.BOLD);
			Font logoFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,Font.ITALIC);
			Font nameFont = new Font(Font.FontFamily.HELVETICA, 10,Font.ITALIC);
			Font fechaFont = new Font(Font.FontFamily.TIMES_ROMAN, 10,Font.ITALIC);
			Font textoFont = new Font(Font.FontFamily.HELVETICA, 10);
			Font subTituloFont = new Font(Font.FontFamily.HELVETICA, 10,Font.BOLDITALIC);
			
			String logoName = "CoronaTickets.uy";
			Paragraph par = new Paragraph(logoName, logoFont);
			Paragraph fecha = new Paragraph("Montevideo, " + fechaActual, fechaFont);
			par.setAlignment(Paragraph.ALIGN_RIGHT);
			fecha.setAlignment(Paragraph.ALIGN_RIGHT);
			doc.add(par);
			doc.add(fecha);
			LineSeparator ls = new LineSeparator();
			doc.add(new Chunk(ls));
			
			Paragraph titulo = new Paragraph("Certificación del premio", catFont);
			titulo.setSpacingAfter(30);
	        doc.add(titulo);
	        
	        String presentacion = "Estimado/a " + nombreU + " " + apellido + ";";
	        Paragraph userName = new Paragraph(presentacion,nameFont);
	        userName.setSpacingAfter(10);
	        doc.add(userName);
	        
	        String contenido1 = "Por medio de la presente hacemos de su conocimiento la autorización del reclamo del premio "
	        		+ "obtenido a partir del registro a la función " + nomFun + " correspondiente al espectáculo "
	        		+ nomEspect + ".";
	        Paragraph texto1 = new Paragraph(contenido1,textoFont);
	        texto1.setSpacingAfter(5);
	        doc.add(texto1);
	        
	        String contenido2 = "Este certificado tiene validez hasta 30 días hábiles pasada la fecha de sorteo(" + fechaHabil + ")."
	        		+ " Pasada dicha fecha no se aceptarán reclamos bajo ningún término.";
	        Paragraph texto2 = new Paragraph(contenido2,textoFont);
	        texto2.setSpacingAfter(12);
	        doc.add(texto2);
	        
	        String subTitulo1 = "Descripción del premio:";
	        Paragraph texto3 = new Paragraph(subTitulo1,subTituloFont);
	        doc.add(texto3);
	        
	        Font text2Font = new Font(Font.FontFamily.HELVETICA, 10,Font.ITALIC);
	        String descPremio = funcion.getDescriPremio();
	        Paragraph texto4 = new Paragraph(descPremio,text2Font);
	        texto4.setSpacingAfter(10);
	        doc.add(texto4);
	        
	        String instrucciones = "El mismo debe de ser retirado en el Departamento de Coordinación Administrativa presentando documento "
	        		+ " y el presente certificado con la firma de la persona en referencia.";
	        Paragraph texto5 = new Paragraph(instrucciones,textoFont);
	        texto5.setSpacingAfter(10);
	        doc.add(texto5);
	        
	        String alert = "Atención: ";
	        Paragraph texto6 = new Paragraph(alert,subTituloFont);
	        doc.add(texto6);
	        
	        String descAlert = "Cualquier intento de falsificación del certificado será sancionado en el marco de la Ley 9.155(Art.242).";
	        Paragraph texto7 = new Paragraph(descAlert,text2Font);
	        texto7.setSpacingAfter(60);
	        doc.add(texto7);
	        
	        
	        
	        Paragraph firma = new Paragraph("Firma: ");
	        firma.add(new Chunk(new DottedLineSeparator()));
	        firma.setSpacingAfter(30);
	        doc.add(firma);
	        
	        Paragraph acla = new Paragraph("Aclaración: ");
	        acla.add(new Chunk(new DottedLineSeparator()));
	        acla.setSpacingAfter(120);
	        doc.add(acla);
	        
	        Font datosFont = new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.ITALIC);
	        Font urlFont = new Font(Font.FontFamily.TIMES_ROMAN, 8,Font.UNDERLINE);
	        String datos1 = "Depto. de Coordinación Administrativa";
	        String datos2 = "Av. 18 de Julio y Paraguay 1284";
	        String datos3 = "www.coronatickets.uy";
	        
	        Paragraph d1 = new Paragraph(datos1,datosFont);
	        d1.setAlignment(Paragraph.ALIGN_CENTER);
	        
	        Paragraph d2 = new Paragraph(datos2,datosFont);
	        d2.setAlignment(Paragraph.ALIGN_CENTER);
	        
	        Paragraph d3 = new Paragraph(datos3,urlFont);
	        d3.setAlignment(Paragraph.ALIGN_CENTER);
	        doc.add(d1);
	        doc.add(d2);
	        doc.add(d3);
	        
	        
	        /*String imageFile = "/WebContent/resources/media/stuartTriste.png"; 
	        Image image = Image.getInstance(ClassLoader.getSystemResource(imageFile));
	        doc.add(image);*/
	        
			//Anchor anchor = new Anchor("First Chapter");
	        //anchor.setName("First Chapter");
	        
	        
	        // Second parameter is the number of the chapter
	        //Chapter catPart = new Chapter(new Paragraph("nfiewbfewih"), 1);
			//doc.add(catPart);
			
			doc.close(); 
  	 
  	  }catch(DocumentException e){
  		  e.printStackTrace();
  	  }
  	  catch(Exception e){
  		  e.printStackTrace();
  	  }
  	 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		processRequest(request, response);
	}

}
