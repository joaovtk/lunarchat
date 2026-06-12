package org.tk.lunarchat.Database.Config;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.tk.lunarchat.Database.Model.User;
public interface UserRepo extends MongoRepository<User, String>{
    User findByUsername(String username);
}
