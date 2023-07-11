package repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PackageBoxController {
    private final PackageRepository pckgService;

    @Autowired
    public PackageBoxController(PackageRepository pckgService) {
        this.pckgService = pckgService;
    }

    @PostMapping(value = "/packages")
    public ResponseEntity<?> add(@RequestBody PackageBox pckg) {
        pckgService.add(pckg);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/packages")
    public ResponseEntity<List<PackageBox>> getArray() {
        final List<PackageBox> packages = pckgService.getArray();

        return packages != null && !packages.isEmpty()
                ? new ResponseEntity<>(packages, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping (value = "/packages/{Id}")
    public ResponseEntity<PackageBox> read(@PathVariable(name = "Id") int Id) {
        final PackageBox pckg = pckgService.read(Id);

        return pckg != null
                ? new ResponseEntity<>(pckg, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/packages/{Id}")
    public ResponseEntity<?> update(@PathVariable(name = "Id") int Id, @RequestBody PackageBox pckg) {
        final boolean updated = pckgService.update(pckg, Id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/packages/{Id}")
    public ResponseEntity<?> remove(@PathVariable(name = "Id") int Id) {
        final boolean deleted = pckgService.remove(Id);

        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }


}
