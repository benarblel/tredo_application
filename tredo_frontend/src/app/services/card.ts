import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Card } from '../models/card';

@Injectable({ providedIn: 'root' })
export class CardService {
    private url = 'http://localhost:8080/api/lists';

    constructor(private http: HttpClient) {}

    getByList(listId: number): Observable<Card[]> {
        return this.http.get<Card[]>(`${this.url}/${listId}/cards`);
    }

    create(listId: number, data: { title: string, description: string, position: number }): Observable<Card> {
        return this.http.post<Card>(`${this.url}/${listId}/cards`, data);
    }

    update(listId: number, id: number, data: { title: string, description: string, position: number }): Observable<Card> {
        return this.http.put<Card>(`${this.url}/${listId}/cards/${id}`, data);
    }

    delete(listId: number, id: number): Observable<void> {
        return this.http.delete<void>(`${this.url}/${listId}/cards/${id}`);
    }
}