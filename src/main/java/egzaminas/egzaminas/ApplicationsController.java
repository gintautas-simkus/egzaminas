package egzaminas.egzaminas;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
@RequestMapping("applications")
public class ApplicationsController {
	@Autowired
	private ApplicationsRepository applicationsRepository;
	@Autowired
	private SchoolsRepository schoolsRepository;
	@Autowired
	private UsersRepository usersRepository;

	/*
	@GetMapping("")
	public String index(Model model)
	{		
		model.addAttribute("schools", schoolsRepository.findAll());
		return "schools/index";
	}
	
	@GetMapping(value = "{id}")
	public String index(@PathVariable Long id, Model model)
	{		
		model.addAttribute("school", schoolsRepository.findById(id));
		return "schools/show";
	}
	*/
	
	@PostMapping("")
	public String create(
			@RequestParam(name = "name", required = true) String name,
			@RequestParam(name = "school_id", required = true) Long schoolId) throws Exception
	{
		School school = schoolsRepository.findById(schoolId).get();
		String email = ((org.springframework.security.core.userdetails.User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		User user = usersRepository.findByEmail(email);
		Application application = new Application(school, user, name);
		applicationsRepository.save(application);
		return "redirect:/";
	}
	
	@PostMapping("delete")
	public void delete(@RequestParam(name = "id", required = true) Long id,
			HttpServletResponse response)
	{
		applicationsRepository.deleteById(id);
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
	}
}