package com.example.schoolmanagementhwday21.Controller;

import com.example.schoolmanagementhwday21.ApiResponse.ApiResponse;
import com.example.schoolmanagementhwday21.DTO.AddressDTO;
import com.example.schoolmanagementhwday21.Service.AddressService;
import com.example.schoolmanagementhwday21.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService ;
    private final TeacherService teacherService;


    @GetMapping("/get")
    public ResponseEntity getAllAddress(){
        return ResponseEntity.status(200).body(addressService.getAllAddress());
    }



    @PostMapping("/add")
    public ResponseEntity addAddress(@RequestBody @Valid AddressDTO addressDTO ){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address added"));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity updateAddress(@PathVariable  Integer id,@RequestBody @Valid AddressDTO addressDTO ){
        addressService.updateAddress(id,addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("Address update"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.delteAddress( id);
        return ResponseEntity.status(200).body(new ApiResponse("Address deleted"));
    }


}
