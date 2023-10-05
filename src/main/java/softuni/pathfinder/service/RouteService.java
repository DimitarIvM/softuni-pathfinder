package softuni.pathfinder.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.pathfinder.model.dto.AddRouteDTO;
import softuni.pathfinder.model.entity.CategoryEntity;
import softuni.pathfinder.model.entity.RouteEntity;
import softuni.pathfinder.model.entity.enums.Category;
import softuni.pathfinder.repository.CategoryRepository;
import softuni.pathfinder.repository.RouteRepository;
import softuni.pathfinder.repository.UserRepository;
import softuni.pathfinder.utils.CurrentUser;

import java.util.Set;


@Service
public class RouteService {

    private RouteRepository routeRepository;
    private CurrentUser currentUser;
  private   UserRepository userRepository;
  private ModelMapper modelMapper;
  private CategoryRepository categoryRepository;

    public RouteService(RouteRepository repository, CurrentUser currentUser, UserRepository userRepository, ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.routeRepository = repository;

        this.currentUser = currentUser;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }


    public void addRoute(AddRouteDTO addRouteDTO) {


          RouteEntity routeEntity=  modelMapper.map(addRouteDTO, RouteEntity.class);

          routeEntity.getCategories().clear();
          Set<CategoryEntity> categories = categoryRepository.findByNameIn(addRouteDTO.getCategories());
          routeEntity.addCategories(categories);
          routeRepository.save(routeEntity);


    }


}
