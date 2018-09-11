package mongo;

import com.mongodb.*;

/*
 *@description:
 *
 *@author 10068921(LgyTT)
 *@date 2018/9/3 15:16
 */
public class MongoMain {
    public static void main(String [] args){

        /**
         * Mongo类代表与MongoDB服务器的连接，有多种构造函数。无参构造函数默认连接localhost:27017.
         */
        Mongo connection = new Mongo("localhost:27017");
        /**
         * DB类代表数据库，如果当前服务器上没有该数据库，会默认创建一个
         */
        DB db = connection.getDB("me");
        /**
         * DBCollection代表集合，如果数据库中没有该集合，会默认创建一个
         */
        DBCollection users = db.getCollection("col");
        /**
         * DBObject代表文档，这是一个接口，java中提供了多种实现，最简单的就是BasicDBObject了
         */
        DBObject col = new BasicDBObject();
        col.put("title", "MongoDB");
        col.put("description", "MongoDB 是一个 Nosql 数据库");
        DBObject tags = new BasicDBObject();
        tags.put("m", "mongodb");
        tags.put("d", "database");
        tags.put("n", "NoSql");
        /**
         * 对于内嵌文档，我们需要先将内嵌文档填充后，再填充到外层文档中！
         */
        col.put("address", tags);
        // 将该文档插入到集合中
      //  users.insert(col);
        // 从集合中查询数据，我们就查询一条，调用findOne即可
        String id="jimmy";
        DBObject dbUser = users.findOne(id);
        System.out.println("name" + " : "  + dbUser.get("_id") );
        System.out.println("age" + " : "  + dbUser.get("age") );
        DBObject dbTags = (DBObject)col.get("address");
        System.out.println("city" + " : "  + dbTags.get("m") );
        System.out.println("street" + " : "  + dbTags.get("d") );
        System.out.println("mail" + " : "  + dbTags.get("n") );

    }
}
