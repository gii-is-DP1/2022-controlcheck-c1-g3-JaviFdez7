package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecoveryRoomService {

    RecoveryRoomRepository recoveryRoomRepository;

    @Autowired
    public RecoveryRoomService(RecoveryRoomRepository recoveryRoomRepository){
        this.recoveryRoomRepository = recoveryRoomRepository;
    }

    @Transactional(readOnly = true)
    public List<RecoveryRoom> getAll(){
        return this.recoveryRoomRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<RecoveryRoomType> getAllRecoveryRoomTypes(){
        return null;
    }

    @Transactional(readOnly = true)
    public RecoveryRoomType getRecoveryRoomType(String typeName) {
        return this.recoveryRoomRepository.getRecoveryRoomType(typeName);
    }

    @Transactional(readOnly = true)
    public RecoveryRoom save(RecoveryRoom p){ 
        return recoveryRoomRepository.save(p);       
     
    }

    
}
