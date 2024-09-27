package ApiTest.Api.controllers;
import ApiTest.Api.domain.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class CustomerController {
    private List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(00, "Nicolas", "Gonzales", "123456"),
            new Customer(01, "Eduardo", "Fernandez", "654321"),
            new Customer(02, "Adrian", "Hernandez", "987564321"),
            new Customer(03, "Marcelo", "Gallardo", "951747")
    ));

    // @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> getCustomers() {
        return customers;
    }

    @GetMapping("/{username}")
    public Customer getCliente(@PathVariable String username) {
        for (Customer c : customers) {
            if (c.getUsername().equalsIgnoreCase(username)) {
                return c;
            }
        }
        return null;
    }

    @PostMapping
    public Customer postCliente(@RequestBody Customer customer){
        customers.add(customer) ;
        return customer ;
    }

    @PutMapping
    public Customer putCliente (@RequestBody Customer customer ) {
        for( Customer cliente : customers) {
            if( cliente.getID() == customer.getID()){
                cliente.setName(customer.getName());
                cliente.setUsername(customer.getUsername());
                cliente.setPassword(customer.getPassword());

                return cliente ;
            }
        }
        return null ;
    }

    // @DeleteMapping("/{id}")
    @RequestMapping( value = "/{id}" , method = RequestMethod.GET)
    public String deleteCliente (@PathVariable int id) {
        for( Customer cliente : customers) {
            if( cliente.getID() == id) {
               customers.remove(cliente) ;
               return "Usuario Eliminado" ;
            }
        }
        return "No se encontro Usuario" ;
    }

    @PatchMapping
    public Customer patchCliente (@RequestBody  Customer customer) {
        for(Customer c : customers) {
            if( c.getID() ==  customer.getID()){
                if(customer.getName() != null){
                    c.setName(customer.getName());
                }
                if(customer.getUsername() != null){
                    c.setUsername(customer.getUsername());
                }
                if(customer.getPassword() != null){
                    c.setPassword(customer.getPassword());
                }

                return c ;
            }
        }
        return null ;
    }


}