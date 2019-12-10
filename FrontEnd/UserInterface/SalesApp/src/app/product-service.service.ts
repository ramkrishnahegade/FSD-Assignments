import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders} from  '@angular/common/http'
import { Product } from './product/product';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  constructor(private _httpClient:HttpClient) { }

  addProduct(product:Product): Observable<Product>{
  if(product!=null){
    return this._httpClient.post<Product>('http://localhost:8080/stock/task/addProduct',product,
    {headers:new HttpHeaders({
      'Access-Control-Allow-Origin':'*',  
      'Content-type':'application/json'
    })}   )
  }
  }

  getAllProduct():Observable<Product[]>{
    return this._httpClient.get<Product[]>('http://localhost:9090/inventory/getProducts/');
  }
}
