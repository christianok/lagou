package persistence.mapper;

import persistence.entity.User;

public interface UserMapper {
    User selectOne(User user);
}
