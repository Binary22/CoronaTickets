package Persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;




public class Test {
	private void inicializarArticulos(EntityManager em) {
		TypedQuery<Espectaculos> select = em.createQuery("SELECT e FROM Espectaculos e ", Espectaculos.class);
		List<Espectaculos> espects = select.getResultList();
		if (espects.isEmpty()) {
			Espectaculos e1 = new Espectaculos(), e2 = new Espectaculos(), e3 = new Espectaculos();
			e1.setNombre("Harry Potter");
			e1.setDescripcion("La historia de harry");
			
			e2.setNombre("Harry Potter 2");
			e2.setDescripcion("La historia de harry 2");
			
			e3.setNombre("Harry Potter 3");
			e3.setDescripcion("La historia de harry 3");
		
			em.getTransaction().begin();
			em.persist(e1);
			em.persist(e2);
			em.persist(e3);
			em.getTransaction().commit();
		} else {
			for (Object object : espects) {
				System.out.println("Espectaculo: " + object);
			}
		}
	}

	public void test() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DataBaseII");
		EntityManager em = emf.createEntityManager();
		try {
			// Se inicializan los articulos si es necesario.
			inicializarArticulos(em);

			// Se solicita una transaccion al entity manager
			em.getTransaction().begin();
			Funciones fun = new Funciones();
			Espectaculos e1 = null, e2 = null;

			// obtengo un articulo a traves de una query por nombre
			TypedQuery<Espectaculos> select = em.createQuery("SELECT e FROM Espectaculos e WHERE e.nombre = :nombre",
					Espectaculos.class);
			select.setParameter("nombre", "Harry Potter");
			// Cuidado! si hay mas de un resultado retorna error.
			e1 = (Espectaculos) select.getSingleResult();

			//LineaFactura lin1 = new LineaFactura(), lin2 = new LineaFactura();
			
			fun.setNombre("Harry Potter 1");
			fun.setEspect(e1);
			/*fct.setIva(22);

			lin1.setDetalle("Compra 1");
			lin1.setArticulo(ar);
			lin1.setCantidadArticulo(2);

			ar2 = new Articulo();
			ar2.setNombre("Cable comun");
			ar2.setPrecio(20);

			lin2.setDetalle("Compra 2");
			lin2.setArticulo(ar2);
			lin2.setCantidadArticulo(5);

			ArrayList<LineaFactura> lineas = new ArrayList<LineaFactura>();
			lineas.add(lin1);
			lineas.add(lin2);
			fct.setLineas(lineas);*/

			// Se persisten los objetos que no estan en la base a�n.
			em.persist(fun);
			em.flush();

			em.getTransaction().commit();

			// Se consultan todas las facturas.
			for (Object obj : em.createQuery("Select f from Funciones f").getResultList()) {
				Funciones f = (Funciones) obj;
				System.out.println("************funcion obtenida con una query: " + f);
			}

			/*// Cambiar el id en caso de conocerlo.
			Factura fct1 = em.find(Factura.class, 4L);
			System.out.println("*************factura encontrada usando find: " + fct1);*/
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
	}

}
