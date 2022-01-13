package jpabook.jpashop;

import jpabook.jpashop.domain.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {

    public static void main(String[] args) {

        //DB당 하나만 생성 됨. 웹서비스 시작할떄
        //데이터베이스 하나씩 묶여서 돌아가기 때문에 항상 생성해야됨 .
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 로딩시점 1개만 만들어얃 된다. 설정정보 불러오기

        //고객의 요청이 들어올때마다 아래 로직 실행 쓰레드간 공유 X 사용하고 버리자 서
        //emf 통해서 작업해야된다 .
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Book book = new Book();

            book.setAuthor("ddd");
            book.setName("JPA");
            book.setIsbn("dd");

            em.persist(book);


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();

    }
}
