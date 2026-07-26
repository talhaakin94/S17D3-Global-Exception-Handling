package com.workintech.zoo.controller;
import com.workintech.zoo.entity.Koala;
import com.workintech.zoo.exceptions.ZooErrorResponse;
import com.workintech.zoo.exceptions.ZooException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class KoalaController {
    Map<Integer, Koala> koalas;
    @PostConstruct
    public void init() {
        koalas = new HashMap<>();
    }
    @GetMapping("/koalas")
    public List<Koala> getKoalas() {
        List<Koala> koalasList = new ArrayList<>();
        koalasList.addAll(koalas.values());
        return koalasList;
    }
    @GetMapping("/koalas/{id}")
    public Koala getKoala(@PathVariable int id) {
        if(koalas.get(id) == null || id <= 0) {
            throw new ZooException("invalid id" + id, HttpStatus.NOT_FOUND);
        }
        return koalas.get(id);
    }
    @PostMapping("/koalas")
    public Koala addKoala(@RequestBody Koala koala) {
        if(koala.getId() <= 0) {
            throw new ZooException("invalid koala id " + koala.getId(), HttpStatus.BAD_REQUEST);
        }
        koalas.put(koala.getId(), koala);
        return koala;
    }
    @PutMapping("/koalas/{id}")
    public Koala updateKoala(@PathVariable int id, @RequestBody Koala koala) {
        if(id <= 0 || !koalas.containsKey(id)) {
            throw new ZooException("invalid koala id " + koala.getId(), HttpStatus.BAD_REQUEST);
        }
        koalas.put(id, koala);
        return koala;
    }
    @DeleteMapping("/koalas/{id}")
    public Koala deleteKoala(@PathVariable int id) {
        if(id <= 0 || !koalas.containsKey(id)) {
            throw new ZooException("invalid id " + id, HttpStatus.NOT_FOUND);
        }
        return koalas.remove(id);
    }
}
