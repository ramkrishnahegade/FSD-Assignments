import { Category } from './Category';

export class Product {
    id:string;
    name:string;
    description:string;
    price:number;
    reorder: number;
    totalNumberOfProduct:number;
    stopOrder:boolean;
    category:Category=new Category();
    checked:boolean;


}
