import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LivrosService {

  constructor() { }

  // Método para salvar dados no localStorage
  saveData(key: string, data: any): void {
    localStorage.setItem(key, JSON.stringify(data));
  }

  // Método para obter dados do localStorage
  getData(key: string): any {
    const data = localStorage.getItem(key);
    return data ? JSON.parse(data) : null;
  }

  // Método para remover dados do localStorage
  removeData(key: string): void {
    localStorage.removeItem(key);
  }

  // Método para limpar todos os dados do localStorage
  clearData(): void {
    localStorage.clear();
  } 
}
