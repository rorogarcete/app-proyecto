package com.mycompany.proyecto.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.mycompany.proyecto.model.UnidadMedida;
import com.mycompany.proyecto.service.UnidadMedidaService;

/**
 * Handles requests for the application home page.
 * Anotando una clase Java como @Controller se convierte en un controlador, 
 * es decir, en una clase encargada de recibir las peticiones HttpServletRequest.
 * 
 * El objeto Model simplemente es un mapa donde guardaremos los objetos 
 * que queremos pasar a la vista (es la M de MVC)
 * 
 * @author rodrigo garcete
 * Fecha Creacion:21-11-2013
 */

/**
 * Principal componente do framework <code>Spring MVC</code>, esse é o controller do cadastro de mercadorias. 
 * 
 * <p>Tem como responsabilidade: definir o mapeamento de navegação, acionar validadores e conversores de dados, 
 * fornecer e receber os dados da camada de visão (<code>JSP</code>).</p>
 * 
 * <p>Os métodos de navegação, retornam a url definida no Tiles. Veja também o arquivo <code>views.xml</code>.</p>
 * 
 * @author YaW Tecnologia
 */
@RequestMapping(value="/umedida")
@Controller 
public class UnidadMedidaController {
	
	//private static final Logger log = LoggerFactory.getLogger(UnidadMedidaController.class);
	
	private UnidadMedidaService umService;
	
	@Autowired
	public UnidadMedidaController(UnidadMedidaService us){
		this.umService = us;
	}
	 
	/** Configura um conversor para double em pt-BR, usado no campo de preço.
	* @param binder
	*/
//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.registerCustomEditor(Double.class, 
//				new CustomNumberEditor(Double.class, NumberFormat.getInstance(new Locale("es","ES")), true));
//	}
	
//	@InitBinder
//    public void setAllowedFields(WebDataBinder dataBinder) {
//        dataBinder.setDisallowedFields("codigo");
//    }
	
	/**
	 * Ponto de entrada da aplicação ("/").
	 * @param uiModel recebe a lista de mercadorias.
	 * @return url para a pagina de listagem de mercadorias.
	 */
	@RequestMapping(value= "/listado", method = RequestMethod.GET)
	public String listar(Model uiModel) {
		uiModel.addAttribute("umedidas", umService.getAll());
		return "listaUmedidas";
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de insercion de insumos
	 * @param uiModel
	 * @return url de la pagina de insercion
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String crearForm(Model uiModel) {
		uiModel.addAttribute("umedida", new UnidadMedida() );
		//uiModel.addAttribute("active", "incluir");
		//log.debug("Listo para insertar Unidad Medida");
		return "incluirUmedida";
	}
	
	/**
	 * Método ejecutado en la insercion de insumos.
	 * @param instancia de insumo con los datos cargados en la pantalla
	 * @param bindingResult componente utilizado para verificar problemas com validacion
	 * @param uiModel
	 * @return a url para listado, si algun error de validacion fue encontrado, regresa para la pagina de insercion.
	 */
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String crear(@Valid UnidadMedida um, BindingResult bindingResult) { //, Model uiModel
		if (bindingResult.hasErrors()) {
            //uiModel.addAttribute("umedida", um);
            //uiModel.addAttribute("active", "incluir");
            return "incluirUmedida";
        }else {
        	this.umService.save(um);
        	//log.debug("Unidad Medida persistido: "+ um.getCodigo());
    		return "redirect:/umedida/listado";
        }
	}
	
	/**
	 * Método ejecutado antes de cargar la pantalla de edicion de insumos.
	 * @param id del insumo que va a ser editado.
	 * @param uiModel almacena el objeto insumo que debe ser modificado.
	 * @return url de la pagina de edicion.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET) 
	public String editarForm(@PathVariable("id") Long id, Model uiModel) {
		UnidadMedida m = umService.findById(id);
		if (m != null) {
			uiModel.addAttribute("umedida", m);
		}
		return "editarUmedida";
	}
	
	/**
	 * Método executado ao salvar a edição de mercadoria.
	 * @param mercadoria objeto com os dados enviados pela tela.
	 * @param bindingResult componente usado para verificar problemas com validação.
	 * @param uiModel
	 * @return a url para a listagem, se algum erro de validação for encontrado volta para a pagina de edição.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	public String editar(@Valid UnidadMedida um, BindingResult bindingResult, Model uiModel) {
		//UnidadMedida um = umService.findById(id); @PathVariable("id") Long id, 
		if (bindingResult.hasErrors()) {
            uiModel.addAttribute("umedida", um);
            return "editarUmedida";
        }
		this.umService.save(um);
		//log.debug("Unidad Medida actualizado: " + um.getCodigo());
		return "redirect:/umedida/listado";
	}
	
	/**
	 * Método ejecutado para la eliminacion de insumos.
	 * @param id de insumo que debe ser eliminado.
	 * @param uiModel
	 * @return url de la pagina de listado.
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.DELETE)
    public String remover(@PathVariable("id") Long id, Model uiModel) {
		UnidadMedida m = umService.findById(id);
		if (m != null) {
			this.umService.remove(m); 
		}
		return "redirect:/umedida/listado";
    }
	
}