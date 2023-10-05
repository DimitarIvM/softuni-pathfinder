package softuni.pathfinder.web;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import softuni.pathfinder.model.dto.AddRouteDTO;
import softuni.pathfinder.service.RouteService;

@Controller
public class AllRoutesController {

    private RouteService routeService;


    public AllRoutesController(RouteService routeService) {
        this.routeService = routeService;

    }


    @GetMapping("/add-route")
    public ModelAndView addRoute() {

        return new ModelAndView("add-route");
    }

    @PostMapping("/add-route")
    public ModelAndView add(AddRouteDTO addRouteDTO, ModelAndView modelAndView){

routeService.addRoute(addRouteDTO);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
