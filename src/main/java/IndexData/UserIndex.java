package IndexData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;

import Model.UserModel;
/**
 * 为User建索引
 */
public class UserIndex {

	public static void buildIndex(){
		SolrServer server = new HttpSolrServer("http://localhost:7000/solr/user");
		DataFromDB data = new DataFromDB();
		List<UserModel> list = new ArrayList<UserModel>();
		list = data.getUserInfo();
		for (int i = 0; i < list.size(); i++) {
			SolrInputDocument doc = new SolrInputDocument();
			doc.setField("id", list.get(i).getUserid());
			doc.setField("username", list.get(i).getUsername());
			doc.setField("phone", list.get(i).getPhone());
			doc.setField("qq", list.get(i).getQq());
			doc.setField("email", list.get(i).getEmail());
			doc.setField("password", list.get(i).getPassword());
			doc.setField("menuid", list.get(i).getMenuid());
			doc.setField("menuname", list.get(i).getMenuname());
			doc.setField("typename", list.get(i).getTypename());
			doc.setField("price",list.get(i).getPrice());
			doc.setField("describe", list.get(i).getDescribe());
			doc.setField("picUrl", list.get(i).getPicUrl());
			doc.setField("address", list.get(i).getAddress());
			try {
				server.add(doc);
				server.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		System.out.println("Index success");
		}
		
	
	public void deleteById(Integer userid){
		SolrServer server = new HttpSolrServer("http://localhost:7000/solr/user");
		try {
			server.deleteById(userid.toString());
			server.commit();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 运行main方法即可建立索引
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		buildIndex();
	}

}
