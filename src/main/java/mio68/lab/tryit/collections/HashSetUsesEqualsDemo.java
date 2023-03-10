package mio68.lab.tryit.collections;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

/*
  Equals для Entity может быть основан на id (Primary key).
  Но есть особенность id может быть не известен при создании экземпляра а
  может вычисляться позднее после сохранения в БД.
  Equals реализуем следующим образом
  - равны те объекты у которых id установлены и equals

  Но при работе с хэш сетом если
  - добавим в сет объект без id
  - установим id у объекта
  то, сет будет говорить что он не содержит ранее добавленный в него объект!

  Чтобы избежать этого, необходимо реализовывать hashCode как возвращающий одни
  и те же значения, что конечно может уменьшить производительность
  структур данных использующих хэши, но обеспечит корректный контракт и работу
  сета например. Этот подход приводит к тому что хэш нам не помогает и фактически
  всегда работает только equals.
 */

public class HashSetUsesEqualsDemo {

    public static void main(String[] args) {
        Set<User> users = new HashSet<>();

        User user = new User(null, "Bob");
        users.add(user);
        System.out.println("users contains user: " + users.contains(user));

        user.setId(1);
        System.out.println("users contains user: " + users.contains(user));

    }


    @Getter
    @Setter
    @AllArgsConstructor
    private static class User {
        private Integer id;
        private String name;

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof User)) {
                return false;
            }
            if (obj == this) {
                return true;
            }

            User other = (User) obj;
            return id != null && id.equals(other.id);
        }

        // This implementation causes that user not found in the hash set
        // after id is set!
//        @Override
//        public int hashCode() {
//            return Objects.hash(id);
//        }

        // This implementation work fine with hash set.
        @Override
        public int hashCode() {
            return getClass().hashCode();
        }
    }

}
