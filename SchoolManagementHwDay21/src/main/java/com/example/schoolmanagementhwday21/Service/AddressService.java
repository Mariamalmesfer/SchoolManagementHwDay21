package com.example.schoolmanagementhwday21.Service;

import com.example.schoolmanagementhwday21.ApiResponse.ApiException;
import com.example.schoolmanagementhwday21.DTO.AddressDTO;
import com.example.schoolmanagementhwday21.Model.Address;
import com.example.schoolmanagementhwday21.Model.Teacher;
import com.example.schoolmanagementhwday21.Repository.AddressRepository;
import com.example.schoolmanagementhwday21.Repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class AddressService {

    final private TeacherRepository teacherRepository ;
    private final AddressRepository addressRepository ;


    public List<Address> getAllAddress() {

        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());

        if (teacher == null) {
            throw new ApiException("id is null");
        }
        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }



    public void updateAddress(Integer id,AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        Address address = addressRepository.findAddressById(id);

        if(teacher==null){
            throw new ApiException("id not found");
        }
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        address.setTeacher(teacher);


        addressRepository.save(address);

    }


    public void delteAddress(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        Address address = addressRepository.findAddressById(id);

        if (address == null) {
            throw new ApiException("id not found");
        }

        teacher.setAddress(null);
        teacherRepository.save(teacher);
        addressRepository.deleteById(id);
    }






}

