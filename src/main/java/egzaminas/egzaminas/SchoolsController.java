package egzaminas.egzaminas;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Controller
@RequestMapping("schools")
public class SchoolsController {
	@Autowired
	private SchoolsRepository schoolsRepository;

	@GetMapping("")
	public String index(@RequestParam(name = "search", required = false) String search, Model model)
	{	
		System.out.println(search);
		if (search == null) {
			model.addAttribute("schools", schoolsRepository.findAll());
		} else {
			model.addAttribute("schools", schoolsRepository.findByName(search));		
		}
		return "schools/index";
	}
	
	@GetMapping(value = "{id}")
	public String show(@PathVariable Long id, Model model)
	{		
		model.addAttribute("school", schoolsRepository.findById(id).get());
		return "schools/show";
	}
	
	@PostMapping("")
	public String create(
			@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "code", required = true) int code,
			@RequestParam(name = "address", required = true) String address) throws Exception
	{
		School school = new School(name, address, code);
		schoolsRepository.save(school);
		return "redirect:/admin/schools";
	}
	
	@PostMapping("delete")
	public void delete(@RequestParam(name = "id", required = true) Long id,
			HttpServletResponse response)
	{
		schoolsRepository.deleteById(id);
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
}