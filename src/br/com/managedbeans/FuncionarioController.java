package br.com.managedbeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import br.com.beans.Funcionario;
import br.com.sessionbeans.FuncionarioIT;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@ManagedBean
@ViewScoped
public class FuncionarioController implements Serializable {

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private JasperPrint jasperPrint;
	
	@EJB
	private FuncionarioIT dao;
	
	public FuncionarioController() {
	}
	
	@PostConstruct
	public void init(){
		this.funcionario = new Funcionario();
		this.funcionarios = dao.listFuncionarios();
	}
	
	
	
	public void addFuncionario(){
		dao.addFuncionario(this.funcionario);
		funcionario = new Funcionario();
		this.funcionarios = dao.listFuncionarios();
	}
	
	public void initReport() throws JRException{
		JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(this.funcionarios);
		String realPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/");
		System.out.println(realPath);
		String path = realPath + "WEB-INF/reports/funcionario.jasper";
		jasperPrint = JasperFillManager.fillReport(path, null, source);
	}
	
	public void gerarPDF() throws JRException, IOException{
		initReport();
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		response.reset();
		response.setContentType("application/pdf");
		response.setHeader("Content-disposition", "attachment; filename=\"relatorio.pdf\"");
		ServletOutputStream stream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
		FacesContext.getCurrentInstance().responseComplete();
	}
	


	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}



	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	
	
	
	
	
}
