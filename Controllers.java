package repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class PackageBoxController {
    @Autowired
    private PackageBox Package;

    @GetMapping("/")
    public List<PackageBox> getPackageBoxList(){
        return service.getAll();
    }
    @GetMapping("/{id}")
    public PackageBox getById(@PathVariable String id){
        return Package.getById(Long.parseLong(id));
    }
    @PostMapping("/")
    public List<City> createNew(){
        service.saveNewCity();
        return service.getAll();
    }
    @PutMapping("/")
    public void update(@RequestBody City city){
        service.update(city);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id){
        service.delete(id);
    }
}
