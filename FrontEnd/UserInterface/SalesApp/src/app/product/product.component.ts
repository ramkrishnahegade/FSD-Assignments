import { Component, OnInit } from '@angular/core';
import { Product } from './product';
import {ProductServiceService} from '../product-service.service'
import { Category } from './Category';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  constructor(private _productService:ProductServiceService) { }
  productModel:Product = new Product();
  ngOnInit() {
  }

  onSubmit(){
    console.log("====="+this.productModel);
    this._productService.addProduct(this.productModel).subscribe(
      (data:Product)=>{
        console.log("Saved");
      },
    (error:any) =>{
      console.log("Error -----"+error._productService);
    },
   ()=>{
     console.log(" Procuct Saved successfully");
   }
    );
  }
}
