import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Board } from '../models/board';

@Injectable({ providedIn: 'root' })
export class BoardService {
    private url = 'http://localhost:8080/api/boards';

    constructor(private http: HttpClient) {}

    getAll(): Observable<Board[]> {
        return this.http.get<Board[]>(this.url);
    }

    getById(id: number): Observable<Board> {
        return this.http.get<Board>(`${this.url}/${id}`);
    }

    create(board: { name: string }): Observable<Board> {
        return this.http.post<Board>(this.url, board);
    }

    update(id: number, board: { name: string }): Observable<Board> {
        return this.http.put<Board>(`${this.url}/${id}`, board);
    }

    delete(id: number): Observable<void> {
        return this.http.delete<void>(`${this.url}/${id}`);
    }
}