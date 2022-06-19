package com.kruger.test.service.controller;

import com.kruger.test.client.entity.Rol;
import com.kruger.test.core.service.RolService;
import com.kruger.test.vo.request.RoleRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RolService roleService;

    @GetMapping("/all")
    public List<Rol> findAllRoles(){
        return this.roleService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Rol> findRoleById(@PathVariable(value = "id") Integer id){
        return this.roleService.findById(id);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody RoleRequest role){
        Rol rol = new Rol();
        rol.setType(role.getType());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.roleService.create(rol));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody RoleRequest role, @PathVariable(value = "id") Integer id){
        Rol rolOld = this.roleService.findById(id).get();
        rolOld.setType(role.getType());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.roleService.update(rolOld));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Integer id) {
        this.roleService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Registro eliminado");
    }
}
