package cn.edu.hdu.jedisdemo;

import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	JedisPool pool = new JedisPool(new JedisPoolConfig(), "localhost");
    	/// Jedis implements Closable. Hence, the jedis instance will be auto-closed after the last statement.
    	try (Jedis jedis = pool.getResource()) {
    	  /// ... do stuff here ... for example
    	  jedis.set("foo", "bar");
    	  String foobar = jedis.get("foo");
    	  jedis.zadd("sose", 0, "car"); 
    	  jedis.zadd("sose", 0, "bike"); 
    	  Set<String> sose = jedis.zrange("sose", 0, -1);
    	  System.out.println(foobar);
    	  System.out.println(sose);
    	}
    	/// ... when closing your application:
    	pool.close();
    }
}
