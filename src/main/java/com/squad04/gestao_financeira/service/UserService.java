/* package service;

import com.squad04.gestao_financeira.dto.CreateUserDto;
import com.squad04.gestao_financeira.dto.UpdateUserDto;
import Repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

   private UserRepository userRepository;

   public UserService(UserRepository userRepository) {
       this.userRepository = userRepository;
   }

   public UUID createUser (CreateUserDto createUserDto) {

       var entity = new User (
               UUID.randomUUID(),
               createUserDto.username(),
               createUserDto.email(),
               createUserDto.password(),
               instant.now(),
               updateTimestamp: null);

      var userSaved = userRepository.save(entity);

      return userSaved.getUserId();

   }

   public Optional<User> getUserById (String userId) {

       return userRepository.findById (UUID.fromString(userId))
   }

   public List <User> ListUsers () {
       return userRepository.findAll();
   }

   public void updateUserById (String userId, UpdateUserDto updateUserDto) {

       var id = UUID.fromString(userId);

       var userEntity userRepository.findById(id);

       if (userEntity.isPresent()) {
           var user = userExists.get();

           if (updateUserDto.username() != null ) {
               user.setUsername(updateUserDto.username());
           }
           if (updateUserDto.password() != null ) {
               user.setPassword(updateUserDto.password());
           }

           userRepository.save(user);
       }
   }

   public void deleteById (String userId) {
       var id = UUID.fromString(userId);
       var userExists = userRepository.existsById();

       if (userExists) {
           userRepository.deleteById (id);
       }
   }
}
*/