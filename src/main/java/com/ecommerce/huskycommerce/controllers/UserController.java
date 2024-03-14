package com.ecommerce.huskycommerce.controllers;

import com.ecommerce.huskycommerce.dto.ProductDTO;
import com.ecommerce.huskycommerce.dto.UserDTO;
import com.ecommerce.huskycommerce.services.ProductService;
import com.ecommerce.huskycommerce.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;


@RestController
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  private UserService service;

  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
  @GetMapping(value = "/profile")
  public ResponseEntity<UserDTO> getProfile() {
    UserDTO dto = service.getProfile();
    return ResponseEntity.ok(dto);
  };
};
