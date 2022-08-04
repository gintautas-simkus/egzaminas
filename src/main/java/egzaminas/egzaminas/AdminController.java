package egzaminas.egzaminas;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("admin")
public class AdminController {
	@Autowired
	private SchoolsRepository schoolsRepository;

	@GetMapping("schools")
	public String schools(Model model)
	{
		model.addAttribute("schools", schoolsRepository.findAll());
		return "admin/schools";
	}
/*
	@PostMapping("")
	public String create(@RequestParam(name = "pavadinimas", required = true) String pavadinimas) throws Exception
	{
		Dalykas dalykas = new Dalykas(pavadinimas);
		dalykaiRepository.save(dalykas);
		return "redirect:/dalykai";
	}

	@PostMapping("delete")
	public void delete(@RequestParam(name = "id", required = true) Long id,
			HttpServletResponse response)
	{
		dalykaiRepository.deleteById(id);
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
*/
}