import React from 'react';
import {Link} from 'react-router-dom';

const bookTerm = (props) => {

    return (
        <tr key={props.term.id}>
            <td>{props.term.name}</td>
            <td>{props.term.author.name}</td>
            <td>{props.term.category}</td>
            <td>{props.term.availableCopies}</td>
            <td className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)}>
                    Delete
                </a>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.term.id)}
                      to={`/books/edit/${props.term.id}`}>
                    Edit
                </Link>
                <button title={"Take copy"} className={"btn btn-warning ml-2"}
                        onClick={() => props.onTakeCopy(props.term.id)}>
                    Take copy
                </button>
            </td>
        </tr>
    )
}

export default bookTerm;