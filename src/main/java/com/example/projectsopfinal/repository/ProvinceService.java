//package com.example.projectsopfinal.repository;
//
//import com.example.projectsopfinal.model.Province;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class ProvinceService {
//    private ProvinceRepository provinceRepository;
//    public ProvinceService(ProvinceRepository provinceRepository){
//        this.provinceRepository = provinceRepository;
//    }
//    public Province saveProvince(Province province){
//        return provinceRepository.save(province);
//    }
//
//    public Iterable<Province> getAllProvinces(){
//        return provinceRepository.findAll();
//    }
//
//    public void deleteAllProvinces(){
//        provinceRepository.deleteAll();
//    }
//
//    public Province detailTourByName(String name){
//        return provinceRepository.findByName(name);
//    }
//
//    public Optional<Province> findTourById(String id){
//        return provinceRepository.findById(id);
//    }
//}
