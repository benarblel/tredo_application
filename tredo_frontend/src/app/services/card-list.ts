import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CardList } from '../models/card-list';

@Injectable({ providedIn: 'root' })
export class CardListService {
    private url = 'http://localhost:8080/api/boards';

    constructor(private http: HttpClient) {}

    getByBoard(boardId: number): Observable<CardList[]> {
        return this.http.get<CardList[]>(`${this.url}/${boardId}/lists`);
    }

    create(boardId: number, data: { name: string, position: number }): Observable<CardList> {
        return this.http.post<CardList>(`${this.url}/${boardId}/lists`, data);
    }

    update(boardId: number, id: number, data: { name: string, position: number }): Observable<CardList> {
        return this.http.put<CardList>(`${this.url}/${boardId}/lists/${id}`, data);
    }

    delete(boardId: number, id: number): Observable<void> {
        return this.http.delete<void>(`${this.url}/${boardId}/lists/${id}`);
    }
}